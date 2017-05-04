import { Component } from '@angular/core';
import { Storage } from '@ionic/storage';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { NavController, AlertController } from 'ionic-angular';
import { JwtHelper } from 'angular2-jwt';
import { Login } from '../login/login';
import { OrganizationService } from '../../providers/organizationService';
import { PlayerService } from '../../providers/playerService';

@Component({
  selector: 'page-createPlayer',
  templateUrl: 'createPlayer.html',
  providers: [OrganizationService, PlayerService]
})
export class CreatePlayer {

  listAdministratedOrganizationDto : any;
  createPlayerForm: FormGroup;
  jwtHelper: JwtHelper;

	constructor(public storage: Storage, public navCtrl: NavController, public formBuilder: FormBuilder, private alertCtrl: AlertController, private organizationService: OrganizationService, private playerService: PlayerService) {
		console.log('Constructor CreateTeam');
    this.jwtHelper = new JwtHelper();
    this.storage.ready().then(()=>
      this.storage.get('id_token').then((token) => {
        //Si el token a expirado nos vamos a la pagina de bienvenida
        if(this.jwtHelper.isTokenExpired(token)){
          this.navCtrl.setRoot(Login);
        }else{
          //Recuperamos las organizaciones de las que somos administradores
          this.organizationService.findAdministratedByPrincipal(token).subscribe(data => this.listAdministratedOrganizationDto = data);
        }
      }));
    this.createPlayerForm = formBuilder.group({
      idOrganization: ['0', Validators.compose([Validators.required])],
      name: ['', Validators.compose([Validators.required, Validators.maxLength(50)])],
      surname: ['', Validators.compose([Validators.required, Validators.maxLength(50)])],
      grade: [''],
      position: [''],
      height: [''],
      birthDate: ['']
    });
	}

  createPlayer(){
    console.log('New Player is trying to be created');
    //Tiene errores
    if(!this.createPlayerForm.valid || !this.organizationHasBeenSelected()){
      //Se muestra una alerta de error
      let alert = this.alertCtrl.create({
        title: 'Player Error',
        subTitle: 'Player has invalid values',
        buttons: ['OK']
      });
      alert.present();
    }else {
      console.log('There is not error in the form. Next Step: Call to provider');
      this.storage.ready().then(()=>
        this.storage.get('id_token').then((token) => {
          //Si el token a expirado nos vamos a la pagina de bienvenida
          if(this.jwtHelper.isTokenExpired(token)){
            this.navCtrl.setRoot(Login);
          }else{

            this.playerService.create(this.createPlayerForm.value, token).subscribe(
              data => {
                let alert = this.alertCtrl.create({
                  title: 'Player created',
                  subTitle: 'The Player has been created properly',
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
              () => console.log('Call to player.create finished')
            );

          }
        }));
    }
  }

  //Comprueba que se ha seleccionado una organization
  organizationHasBeenSelected(){
    return this.createPlayerForm.value.idOrganization != null && this.createPlayerForm.value.idOrganization > 0;
  }

}
