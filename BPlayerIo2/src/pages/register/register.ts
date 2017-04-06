import { Component } from '@angular/core';
import { BUserService } from '../../providers/bUserService';

@Component({
	selector: 'page-register',
	templateUrl: 'register.html',
	providers: [BUserService]
})
export class Register {

	bUserToRegisterDto: {username: any, name: any, surname: any, email: any, phoneNumber: any, password: any, rPassword: any};

	constructor(private bUserService: BUserService) {
		console.log('Constructor Register');
		this.bUserToRegisterDto = {username: 'test', name: 'test', surname: 'test', email: 'test', phoneNumber: 'test', password: 'test', rPassword: 'test'};
	}

	registerBUser(){
		console.log('New BUser is trying to register');
		let errores = this.validateBUserToRegisterDto();
		if(errores.length==0){
      this.bUserService.register(this.bUserToRegisterDto).subscribe(
        data => {
          console.log(data);
        },
        err => {
          console.log(err);
        },
        () => console.log('Call to bUserService.register finished')
      );
    }else{
		  console.log('Register Form has some errors ')
    }

	}

	//Valida que el usuario tenga todos los campos rellenos, si algo falla lo imprime por el log
	validateBUserToRegisterDto(){
    let errores: Array<String> = [];
		if(this.bUserToRegisterDto!=null){
			if(this.bUserToRegisterDto.username==null || this.bUserToRegisterDto.username==''){
				console.log('Username can not be empty');
				errores.push('Username can not be empty');
			}
			if(this.bUserToRegisterDto.name==null || this.bUserToRegisterDto.name==''){
				console.log('Name can not be empty');
        errores.push('Name can not be empty');
			}
			if(this.bUserToRegisterDto.surname==null || this.bUserToRegisterDto.surname==''){
				console.log('Surname can not be empty');
        errores.push('Surname can not be empty');
			}
			if(this.bUserToRegisterDto.email==null || this.bUserToRegisterDto.email==''){
				console.log('Email can not be empty');
        errores.push('Email can not be empty');
			}
			if(this.bUserToRegisterDto.phoneNumber==null || this.bUserToRegisterDto.phoneNumber==''){
				console.log('Phone Number can not be empty');
        errores.push('Phone Number can not be empty');
			}
			if(this.bUserToRegisterDto.password==null || this.bUserToRegisterDto.password==''){
				console.log('Password can not be empty');
        errores.push('Password can not be empty');
			}else if(this.bUserToRegisterDto.password.length<=5) {
        console.log('Password must have at least 5 characters');
        errores.push('Password must have at least 5 characters');
      }else if(this.bUserToRegisterDto.rPassword==null || this.bUserToRegisterDto.rPassword==''){
        console.log('Confirm Password can not be empty');
        errores.push('Confirm Password can not be empty');
      }else if(this.bUserToRegisterDto.password!=this.bUserToRegisterDto.rPassword){
        console.log('Password and Confirm Password must match');
        errores.push('Password and Confirm Password must match');
      }
		}else{
			console.log('BUserToRegisterDto can not be null');
      errores.push('BUserToRegisterDto can not be null');
		}
		return errores;
	}
}