/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dochef.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import dochef.message.Message;
import dochef.message.MessageType;
import dochef.model.Role;
import dochef.model.User;
import dochef.repository.UserRepository;
import dochef.social.SignInUtils;

@Controller
public class SignupController {

	private final UserRepository userRepository;
	private final ProviderSignInUtils providerSignInUtils;

	@Autowired
	public SignupController(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.providerSignInUtils = new ProviderSignInUtils();
	}

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public SignupForm signupForm(WebRequest request) {
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		if (connection != null) {
			request.setAttribute("message", new Message(MessageType.INFO, "Your " + StringUtils.capitalize(connection.getKey().getProviderId()) + " account is not associated with a Spring Social Showcase account. If you're new, please sign up."), WebRequest.SCOPE_REQUEST);
			return SignupForm.fromProviderUser(connection.fetchUserProfile());
		} else {
			return new SignupForm();
		}
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid SignupForm form, BindingResult formBinding, WebRequest request) {
		if (formBinding.hasErrors()) {
			return null;
		}
		User user = createUser(form, formBinding);
		if (user != null) {
			SignInUtils.signin(user.getEmail());  //TODO REVISAR SI FUNCIONA CON EMAIL
			providerSignInUtils.doPostSignUp(user.getEmail(), request);
			return "redirect:/";
		}
		return null;
	}

	// internal helpers
	
	private User createUser(SignupForm form, BindingResult formBinding) {
		try {
			User user = userRepository.findByEmail(form.getUsername());
			if(user!=null)
					throw new UsernameAlreadyInUseException("El " + form.getUsername() + " ya esta registrado");
			user = new User(form.getUsername(), form.getFirstName(), form.getLastName(), form.getPassword());
			
			user.setRole(Role.ROLE_FREE);
			userRepository.save(user);
			return user;
		} catch (UsernameAlreadyInUseException e) {
			formBinding.rejectValue("username", "user.duplicateUsername", "already in use");
			return null;
		}
	}

}
