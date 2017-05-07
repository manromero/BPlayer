import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { NavController, NavParams, AlertController } from 'ionic-angular';
import { JwtHelper } from 'angular2-jwt';
import { Login } from '../login/login';
import { Main } from '../main/main';
import { CreateTeam } from '../createTeam/createTeam';
import { OrganizationService } from '../../providers/organizationService';
import { BUserService } from '../../providers/bUserService';

@Component({
  selector: 'page-detailsOrganization',
  templateUrl: 'detailsOrganization.html',
  providers: [OrganizationService, BUserService]
})
export class DetailsOrganization {

  organization: any;
  jwtHelper: JwtHelper;

	constructor(public storage: Storage, public navCtrl: NavController, public navParams: NavParams, private organizationService: OrganizationService, private bUserService: BUserService, private alertCtrl: AlertController) {
		console.log('Constructor CreateTeam');
    this.jwtHelper = new JwtHelper();
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
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
    //Antes de la llamada al web service necesitamos recuperar el token
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
        }else{

          //LLamamos a la funcion que recupera los administradores
          this.bUserService.findListBUserToBeAdministrator(this.organization.id, token).subscribe(


            data => {
              let listBUserToBeAdministrator: any[]  = data;
              console.log(listBUserToBeAdministrator);
              //Opciones de la alerta a mostrar
              var options = {
                title: 'Add a new Administrator',
                buttons: [
                  {
                    text: 'Cancel',
                    role: 'cancel',
                    handler: () => {
                      console.log('Cancel clicked. No administrator is added');
                    }
                  },
                  {
                    text: 'Add',
                    handler: data => {
                      console.log(data);
                      //Se actualiza la lista de administradores
                      this.bUserService.addBUserToOrganization(data,this.organization.id, token).subscribe(administrators => this.organization.administrators = administrators);

                    }
                  }
                ],
                inputs : []
              }
              for(let i=0; i< listBUserToBeAdministrator.length; i++) {
                options.inputs.push({ name : 'options', value: listBUserToBeAdministrator[i].id, label: listBUserToBeAdministrator[i].username, type: 'radio' });
              }
              let alert = this.alertCtrl.create(options);
              alert.present();


            },
            err => {
              console.log(err);
            },
            () => console.log('Call to bUserService.findListBUserToBeAdministrator finished')
          );

        }

      }));
  }

  deleteOrganization(){
    console.log("Delete Organization");
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
        }else{

          var options = {
            title: 'Do you want to delete this organization?',
            buttons: [
              {
                text: 'Cancel',
                role: 'cancel',
                handler: () => {
                  console.log('Cancel clicked. Not to delete organization');
                }
              },
              {
                text: 'Delete',
                handler: () => {
                  console.log('Call to provider to delete organization');
                  let errorsToDelete: any;
                  this.organizationService.deleteOrganizationByIdOrganization(this.organization.id, token).subscribe(


                    data => {

                      errorsToDelete = data;
                      //Si la respuesta contiene errrores, se ha producido un error inexperado
                      if(errorsToDelete.length>0){
                        let errorAlert = this.alertCtrl.create({
                          title: 'Register Error',
                          subTitle: 'An unexpected error has occurred',
                          buttons: ['OK']
                        });
                        errorAlert.present();
                      }else{
                        let confirmAlert = this.alertCtrl.create({
                          title: 'Organization deleted properly',
                          subTitle: 'The organization has benn deleted',
                          buttons: [
                            {
                              text: 'OK',
                              handler: () => {
                                this.navCtrl.setRoot(Main);
                              }
                            }
                          ]
                        });
                        confirmAlert.present();
                      }

                    },
                    err => {
                      console.log(err);
                    },
                    () => console.log('Call to organizationServie.delete finished')

                  );





                }

              }
            ]
          }
          let alert = this.alertCtrl.create(options);
          alert.present();

        }

      }));
  }

}
