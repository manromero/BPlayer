import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { NavController } from 'ionic-angular';
import { Register } from '../register/register';
import { Login } from '../login/login';
import { Main } from '../main/main';


@Component({
  selector: 'page-hello-ionic',
  templateUrl: 'hello-ionic.html'
})
export class HelloIonicPage {

	constructor(public navCtrl: NavController, public storage: Storage) {
		//let storage = new Storage();
		this.storage.ready().then(() => {
			storage.set('name', 'Mr. Pepe');
		});
		this.storage.get('name').then((name) => {
		  console.log('Me: Hey, ' + name + '! You have a very nice name.');
		  console.log('You: Thanks! I got it for my birthday.');
		});
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
