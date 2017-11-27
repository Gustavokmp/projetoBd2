import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { Component } from '@angular/core';
import { HomePage } from '../home/home';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-login',
  templateUrl: 'login.html'
})
export class LoginPage {
  private entrada: FormGroup;
  constructor(private formBuilder: FormBuilder, public navCtrl: NavController) {
    this.entrada = this.formBuilder.group({
      nome: ['',  Validators.required],
      senha: ['', Validators.required],
    });
  }

  login(){
    this.navCtrl.push(HomePage);
  }


}
