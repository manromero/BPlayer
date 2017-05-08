import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { NavController } from 'ionic-angular';
import { JwtHelper } from 'angular2-jwt';
import { Login } from '../login/login';

@Component({
  selector: 'page-createMatch',
  templateUrl: 'createMatch.html'
})
export class CreateMatch {

  jwtHelper: JwtHelper;

	constructor(public storage: Storage, public navCtrl: NavController) {
		console.log('Constructor CreateOrganization');
    this.jwtHelper = new JwtHelper();
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
        }
      }));
	}

}
