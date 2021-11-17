package br.com.qualitylife.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.qualitylife.model.UsuarioLogin;
import br.com.qualitylife.model.UsuarioModel;
import br.com.qualitylife.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioModel> listarUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Optional<UsuarioModel> cadastrarUsuario(UsuarioModel usuario){
		
		if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			return Optional.empty();
		
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		
		return Optional.of(usuarioRepository.save(usuario));
	}
	
	private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.encode(senha);
	}
	
	public Optional<UsuarioModel> atualizarUsuario(UsuarioModel usuario){
		
		if(usuarioRepository.findById(usuario.getId_usuario()).isPresent()) {
			
			Optional<UsuarioModel> buscaUsuario = usuarioRepository.findByEmail(usuario.getEmail());
			
			if(buscaUsuario.isPresent()) {
				if(buscaUsuario.get().getId_usuario() != usuario.getId_usuario())
					return Optional.empty();
			}
			
			usuario.setSenha(criptografarSenha(usuario.getSenha()));
			
			return Optional.of(usuarioRepository.save(usuario));
		}
		
		return Optional.empty();
	}
	
	private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return encoder.matches(senhaDigitada, senhaBanco);
	}
	
	private String gerarBasicToken(String email, String password) {
		
		String tokenBase = email + ":" + password;
		byte[] tokenBase64 = Base64.encodeBase64(tokenBase.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);
	}
	
	public Optional<UsuarioLogin> logar(Optional<UsuarioLogin> usuarioLogin){
		
		Optional<UsuarioModel> usuario = usuarioRepository.findByEmail(usuarioLogin.get().getEmail());
		
		if(usuario.isPresent()) {
			
			if(compararSenhas(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {
				
				String token = gerarBasicToken(usuarioLogin.get().getEmail(), usuarioLogin.get().getSenha());
				
				usuarioLogin.get().setId(usuario.get().getId_usuario());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setSenha(usuario.get().getSenha());
				usuarioLogin.get().setToken(token);
				
				return usuarioLogin;
			}
		}
		
		return Optional.empty();
	}
	
}
