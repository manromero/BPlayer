import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { NavController } from 'ionic-angular';
import { JwtHelper } from 'angular2-jwt';
import { HelloIonicPage } from '../hello-ionic/hello-ionic';
import { OrganizationService } from '../../providers/organizationService';

@Component({
  selector: 'page-myOrganizations',
  templateUrl: 'myOrganizations.html',
  providers: [OrganizationService]
})
export class MyOrganizations {

  listOrganizationDto : any;
  jwtHelper: JwtHelper;

	constructor(public storage: Storage, public navCtrl: NavController, private organizationService: OrganizationService) {
		console.log('Constructor MyOrganizations');
    this.jwtHelper = new JwtHelper();
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(HelloIonicPage);
        }else{

          //Recuperamos la lista de organizations que tiene el usuario actual
          this.organizationService.findAdministratedByPrincipal(token).subscribe(data => this.listOrganizationDto = data);

        }
      }));
	}

}
