import { Component } from '@angular/core';

import { NavController } from 'ionic-angular';

import { Register } from '../register/register';


@Component({
  selector: 'page-hello-ionic',
  templateUrl: 'hello-ionic.html'
})
export class HelloIonicPage {

	constructor(public navCtrl: NavController) {
		
	}
  
  //Va a la pagina de registro
  goToRegisterPage(event) {
    this.navCtrl.push(Register);
  }
}
