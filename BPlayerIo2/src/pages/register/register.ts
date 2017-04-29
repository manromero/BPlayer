import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { NavController, AlertController } from 'ionic-angular';
import { BUserService } from '../../providers/bUserService';
import { Validation } from '../../utils/validation';
import { Login } from '../login/login';


@Component({
	selector: 'page-register',
	templateUrl: 'register.html',
	providers: [BUserService]
})
export class Register {
	bUserToRegisterDtoForm: FormGroup;

	constructor(private bUserService: BUserService, public formBuilder: FormBuilder, private alertCtrl: AlertController, public navCtrl: NavController) {
		console.log('Constructor Register');
    this.bUserToRegisterDtoForm = formBuilder.group({
      username: ['',  Validators.compose([Validators.required, Validators.maxLength(50)])],
      name: ['',  Validators.compose([Validators.required, Validators.maxLength(50)])],
      surname: ['',  Validators.compose([Validators.required, Validators.maxLength(50)])],
      email: ['', Validators.compose([Validators.required, Validators.maxLength(50), Validators.pattern(/^[a-z0-9!#$%&'*+\/=?^_`{|}~.-]+@[a-z0-9]([a-z0-9-]*[a-z0-9])?(\.[a-z0-9]([a-z0-9-]*[a-z0-9])?)*$/i)])],
      phoneNumber: ['',  Validators.compose([Validators.required, Validators.maxLength(50)])],
      password: ['', Validators.compose([Validators.required, Validators.minLength(5), Validators.maxLength(50)])],
      rPassword: ['',  Validators.compose([Validators.required, Validators.minLength(5), Validators.maxLength(50), Validation.passwordMatch])]
    });
	}

	registerBUser(){
		console.log('New BUser is trying to register');
		//Tiene errores
    if(!this.bUserToRegisterDtoForm.valid){
      //Se muestra una alerta de error
      let alert = this.alertCtrl.create({
        title: 'Login error',
        subTitle: 'Form has invalid values',
        buttons: ['OK']
      });
      alert.present();
    }else {
      this.bUserService.register(this.bUserToRegisterDtoForm.value).subscribe(
        data => {
          let alert = this.alertCtrl.create({
            title: 'BUser created',
            subTitle: 'The BUser has been created properly',
            buttons: [{
              text:'OK' , handler: () => {
                this.navCtrl.push(Login);
              }
            }]
          });
          alert.present();
        },
        err => {
          console.log(err);
          let alert = this.alertCtrl.create({
            title: 'Register Error',
            subTitle: 'An unexpected error has occurred',
            buttons: ['OK']
          });
          alert.present();
        },
        () => console.log('Call to bUserService.register finished')
      );
    }
	}

}
