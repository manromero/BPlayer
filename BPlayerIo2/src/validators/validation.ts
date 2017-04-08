import { FormControl } from '@angular/forms';

export class PasswordValidation {

  static passwordMatch(control: FormControl): any {
    if (control.root.value['password'] && control.value && control.root.value['password']==control.value) {
      return null;
    } else {
      //Si se devuelve un valor quiere decir que esta mal, con la
      return {"passwordNotMatch":true};
    }
  }

}
