import { Component } from '@angular/core';

import { NavController } from 'ionic-angular';

import { Register } from '../register/register';
import { Login } from '../login/login';
import { Main } from '../main/main';


@Component({
  selector: 'page-hello-ionic',
  templateUrl: 'hello-ionic.html'
})
export class HelloIonicPage {

	constructor(public navCtrl: NavController) {
		
	}

	//Va a la pagina de registro
	goToLoginPage() {
		this.navCtrl.push(Login);
	}
  
	//Va a la pagina de registro
	goToRegisterPage() {
		this.navCtrl.push(Register);
	}
	
	//Va a la pagina principal
	goToMainPage() {
		this.navCtrl.push(Main);
	}

}
