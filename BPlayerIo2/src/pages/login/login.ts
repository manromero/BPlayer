import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { BUserService } from '../../providers/bUserService';
import { JwtHelper } from 'angular2-jwt';

@Component({
	selector: 'page-login',
	templateUrl: 'login.html',
	providers: [BUserService]
})
export class Login {
	accountCredentials: {username: any, password: any};
	jwtHelper: JwtHelper;
	token: any;
	
	constructor(private bUserService: BUserService, public storage: Storage) {
		console.log('Constructor Login');
		this.accountCredentials = {username: 'login', password: 'login'};
		this.jwtHelper = new JwtHelper();
		//let storage = new Storage();
		this.storage.get('name').then((name) => {
			console.log('Me: Hey, ' + name + '! You have a very nice name.');
		  console.log('You: Thanks! I got it for my birthday.');
		});
		
	}
	
	login(){
		console.log("A BUser is trying to Login");
		this.validateAccountCredentials();
		this.bUserService.login(this.accountCredentials).subscribe(
			data => {
				console.log(data);
			},
			err => {
				console.error(err);
			},
			() => console.log('LLamada a bUserService.register finalizada')
		);
		this.storage.get('id_token').then((token) => {
			console.log('A new token has been generated: ' + token);
			console.log(this.jwtHelper.decodeToken(token));
		});
	}
	
	validateAccountCredentials(){
		if(this.accountCredentials!=null){
			if(this.accountCredentials.username==null || this.accountCredentials.username==''){
				console.log('Username can not be empty');
			}
			if(this.accountCredentials.password==null || this.accountCredentials.password==''){
				console.log('Password can not be empty');
			}
		}else{
			console.log('Credentials can not be null');
		}
	}
		
}
