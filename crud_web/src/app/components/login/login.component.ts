import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  userLoginForm!: FormGroup;
  
  isSubmitting = false;
  errorMessage = '';
  successMessage = '';

  constructor(private customerService: CustomerService,
    private fb: FormBuilder,
    private router: Router) { }

  ngOnInit() {
    this.userLoginForm = this.fb.group({
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required]]
    })
  }

  loginUser() {
    this.isSubmitting = true;
    this.errorMessage = '';
    this.successMessage = '';

    this.customerService.loginUser(this.userLoginForm.value).subscribe({
      next: (res) => {
        console.log('Login successful:', res);
        this.successMessage = 'Login Success !';
        localStorage.setItem('userName', res.name);
        setTimeout(() => {
          this.router.navigateByUrl('/dashboard');
        }, 2000);
      },
      error: (err) => {
        console.error('Login failed:', err);
        this.errorMessage = 'Invalid email or password  !';
        this.isSubmitting = false;
      },
      complete: () => {
        this.isSubmitting = false;
      }
    });
  }

}
