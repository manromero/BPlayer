import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { NavController, AlertController } from 'ionic-angular';
import { JwtHelper } from 'angular2-jwt';
import { HelloIonicPage } from '../hello-ionic/hello-ionic';
import { OrganizationService } from '../../providers/organizationService';
import { TeamService } from '../../providers/teamService';

@Component({
  selector: 'page-createTeam',
  templateUrl: 'createTeam.html',
  providers: [OrganizationService, TeamService]
})
export class CreateTeam {

  listAdministratedOrganizationDto : any;
  createTeamForm: FormGroup;
  jwtHelper: JwtHelper;

	constructor(public storage: Storage, public navCtrl: NavController, public formBuilder: FormBuilder, private alertCtrl: AlertController, private organizationService: OrganizationService, private teamService: TeamService) {
		console.log('Constructor CreateTeam');
    this.jwtHelper = new JwtHelper();
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(HelloIonicPage);
        }else{
          //Recuperamos las organizaciones de las que somos administradores
          this.organizationService.findAdministratedByPrincipal(token).subscribe(data => this.listAdministratedOrganizationDto = data);

        }
      }));
    this.createTeamForm = formBuilder.group({
      name: ['', Validators.compose([Validators.required, Validators.maxLength(50)])],
      idOrganization: ['0', Validators.compose([Validators.required])]
    });
	}

  createTeam(){
    console.log('New Team is trying to be created');
    //Tiene errores
    if(!this.createTeamForm.valid || !this.organizationHasBeenSelected()){
      //Se muestra una alerta de error
      let alert = this.alertCtrl.create({
        title: 'Team Error',
        subTitle: 'Form has invalid values',
        buttons: ['OK']
      });
      alert.present();
    }else {
      console.log('There is not error in the form. Next Step: Call to provider');
      this.storage.ready().then(()=>
        this.storage.get('id_token').then((token) => {
          //Si el token a expirado nos vamos a la pagina de bienvenida
          if(this.jwtHelper.isTokenExpired(token)){
            this.navCtrl.setRoot(HelloIonicPage);
          }else{

            this.teamService.create(this.createTeamForm.value, token).subscribe(
              data => {
                let alert = this.alertCtrl.create({
                  title: 'Team created',
                  subTitle: 'The Team has been created properly',
                  buttons: [{
                    text:'OK' , handler: () => {
                      this.navCtrl.pop();
                    }
                  }]
                });
                alert.present();
              },
              err => {
                console.log(err);
                let alert = this.alertCtrl.create({
                  title: 'Team Error',
                  subTitle: 'An unexpected error has occurred',
                  buttons: ['OK']
                });
                alert.present();
              },
              () => console.log('Call to organization.create finished')
            );

          }
        }));
    }
  }

  //Comprueba que se ha seleccionado una organization
  organizationHasBeenSelected(){
    return this.createTeamForm.value.idOrganization != null && this.createTeamForm.value.idOrganization > 0;
  }

}
