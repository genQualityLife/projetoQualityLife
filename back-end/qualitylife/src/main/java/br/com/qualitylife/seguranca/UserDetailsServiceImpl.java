package br.com.qualitylife.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.qualitylife.model.UsuarioModel;
import br.com.qualitylife.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String usuarioName) throws UsernameNotFoundException{
		Optional<UsuarioModel> user = usuarioRepository.findByEmail(usuarioName);
		user.orElseThrow(() -> new UsernameNotFoundException(usuarioName + " not found."));
		
		return user.map(UserDetailsImpl::new).get();
	}
}
