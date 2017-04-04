import { Component } from '@angular/core';
import { BUserService } from '../../providers/bUserService';

@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
  providers: [BUserService]
})
export class Login {
	
	accountCredentials: {username: any, password: any};
	
	constructor(private bUserService: BUserService) {
		console.log('Constructor Login');
		this.accountCredentials = {username: 'login', password: 'login'};
	}
	
	login(){
		console.log("A BUser is trying to Login");
		this.validateAccountCredentials();
		this.bUserService.login(this.accountCredentials).subscribe(
			data => {
				console.log("Login OK");
				console.log(data);	
			},
			err => {
				console.log("Login failed");
				console.log(err);
			},
			() => console.log('LLamada a bUserService.login finalizada')
		)
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
