import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { NavController} from 'ionic-angular';
import { JwtHelper } from 'angular2-jwt';
import { HelloIonicPage } from '../hello-ionic/hello-ionic';

@Component({
  selector: 'page-detailsOrganization',
  templateUrl: 'detailsOrganization.html'
})
export class DetailsOrganization {

  jwtHelper: JwtHelper;

	constructor(public storage: Storage, public navCtrl: NavController) {
		console.log('Constructor CreateTeam');
    this.jwtHelper = new JwtHelper();
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(HelloIonicPage);
        }else{
          //LLamada al provider para recuperar los datos de la organization


        }
      }));
	}

}
