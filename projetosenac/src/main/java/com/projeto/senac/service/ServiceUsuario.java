package com.projeto.senac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.senac.exceptions.CriptoExistsExpetion;
import com.projeto.senac.exceptions.EmailExistsException;
import com.projeto.senac.util.Util;
import com.projeto.senac.model.Usuario;
import com.projeto.senac.repository.UsuarioRepository;

@Service

public class ServiceUsuario {
@Autowired

	UsuarioRepository usuarioRepository;

	public void salvarUsuario(Usuario user) throws Exception {
		
		try {
			if(usuarioRepository.finByEmail(user.getEmail()) != null) {
				throw new EmailExistsException("Existe um email cadastrado para:"+user.getEmail());
	
			}
			
			user.setSenha(Util.md5(user.getSenha()));
		} 
		
		catch (Exception e) {
			throw new CriptoExistsExpetion("Erro na criptografia da senha!");
			
		}
		
		usuarioRepository.save(user);
		
	}// fim salvarUsuario
	
	
	public Usuario loginUser(String email, String senha) throws Exception {
		
		   Usuario userLogin = usuarioRepository.buscarLogin(email, senha);
		   
		   return userLogin;
	}
	
	
}// fim classe
