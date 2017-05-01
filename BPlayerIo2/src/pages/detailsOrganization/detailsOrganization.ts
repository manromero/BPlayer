import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { NavController, NavParams } from 'ionic-angular';
import { JwtHelper } from 'angular2-jwt';
import { HelloIonicPage } from '../hello-ionic/hello-ionic';
import { CreateTeam } from '../createTeam/createTeam';
import { OrganizationService } from '../../providers/organizationService';

@Component({
  selector: 'page-detailsOrganization',
  templateUrl: 'detailsOrganization.html',
  providers: [OrganizationService]
})
export class DetailsOrganization {

  organization: any;
  listBUserToBeAdministrator: any;
  jwtHelper: JwtHelper;

	constructor(public storage: Storage, public navCtrl: NavController, public navParams: NavParams, private organizationService: OrganizationService) {
		console.log('Constructor CreateTeam');
    this.jwtHelper = new JwtHelper();
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(HelloIonicPage);
        }else{

          //LLamada al provider para recuperar los datos de la organization
          this.organizationService.findDetailedOrganizationByIdOrganization(navParams.get('idOrganization'), token).subscribe(data => this.organization = data);

        }

      }));
	}

  //Va a la pagina de creacion de Team
  goToCreateTeamPage(){
    this.navCtrl.push(CreateTeam);
  }

  //Find BUser that could be a new administrator
  findListBUserToBeAdministrator(){
	  console.log("Find BUser that could be a new administrator");
  }

}
