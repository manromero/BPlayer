import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Register } from '../register/register';
import { Login } from '../login/login';


@Component({
  selector: 'page-hello-ionic',
  templateUrl: 'hello-ionic.html'
})
export class HelloIonicPage {

  //Hace que esta pagina sea la principal si vengo de algun sitio
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

}
