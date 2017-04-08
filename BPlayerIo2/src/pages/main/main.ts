import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { NavController } from 'ionic-angular';
import { JwtHelper } from 'angular2-jwt';
import { HelloIonicPage } from '../hello-ionic/hello-ionic';

@Component({
  selector: 'page-main',
  templateUrl: 'main.html'
})
export class Main {

  usernameFromToken : string;
  jwtHelper: JwtHelper;

	constructor(public storage: Storage, public navCtrl: NavController) {
		console.log('Constructor Main');
    this.jwtHelper = new JwtHelper();
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(HelloIonicPage);
        }else{
          this.usernameFromToken = this.jwtHelper.decodeToken(token).sub;
        }
      }));
	}

}
