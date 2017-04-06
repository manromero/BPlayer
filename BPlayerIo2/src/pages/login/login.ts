import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { BUserService } from '../../providers/bUserService';
import { JwtHelper } from 'angular2-jwt';


@Component({
	selector: 'page-login',
	templateUrl: 'login.html',
	providers: [BUserService]
})
export class Login {
  accountCredentialsForm: FormGroup;
	jwtHelper: JwtHelper;
	token: any;

	constructor(private bUserService: BUserService, public storage: Storage, public formBuilder: FormBuilder) {
		console.log('Constructor Login');
		this.accountCredentialsForm = formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
		this.jwtHelper = new JwtHelper();
		//let storage = new Storage();
		this.storage.get('name').then((name) => {
			console.log('Me: Hey, ' + name + '! You have a very nice name.');
		  console.log('You: Thanks! I got it for my birthday.');
		});

	}

	login(){
		console.log("A BUser is trying to Login");
		//this.validateAccountCredentials();
    if(this.accountCredentialsForm.valid) {
      this.bUserService.login(this.accountCredentialsForm.value).subscribe(
        data => {
          console.log(data);
        },
        err => {
          console.error(err);
        },
        () => console.log('LLamada a bUserService.register finalizada')
      );
      this.storage.ready().then(()=>
        this.storage.get('id_token').then((token) => {
          console.log('A new token has been generated: ' + token);
          console.log(this.jwtHelper.decodeToken(token));
      }));
    }
	}
}
