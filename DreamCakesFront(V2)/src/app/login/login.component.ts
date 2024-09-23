import { Component } from '@angular/core';
import { AuthService } from '../Services/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Jwt } from '../Models/Jwt';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm!: FormGroup;
  
  constructor(
    private service: AuthService,
    private fb: FormBuilder,
    private router: Router

  ){}
  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', [Validators.required]],
    })
  }
  submitForm(): void {
    console.log(this.loginForm.value);
    this.service.login(this.loginForm.value).subscribe(
      (response : Jwt) => {
            const jwToken = response.token;
            console.log("role is :",response.role)
            localStorage.setItem('jwt', jwToken);
            localStorage.setItem('role', response.role);
           this.router.navigateByUrl("/dashboard")
        }
    )
  }
}
