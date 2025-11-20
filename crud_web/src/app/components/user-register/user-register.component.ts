import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent {

  userRegisterForm!: FormGroup;

  isSubmitting = false;
  errorMessage = '';
  successMessage = '';

  constructor(private customerService: CustomerService,
    private fb: FormBuilder,
    private router: Router) { }

  ngOnInit() {
    this.userRegisterForm = this.fb.group({
      name: [null, [Validators.required]],
      phone: [null, [Validators.required]],
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required]]
    })
  }

registerUser() {
  this.isSubmitting = true;
  this.errorMessage = '';
  this.successMessage = '';

  console.log(this.userRegisterForm.value);

  this.customerService.registerUser(this.userRegisterForm.value).subscribe({
    next: (res) => {
      console.log('User Register successful:', res);
      this.successMessage = 'User Register successful!';

      setTimeout(() => {
        this.router.navigateByUrl("/login");
      }, 2000);
    },
    error: (err) => {
      console.error('User Register failed:', err);
      this.errorMessage = 'User Register failed!';
      this.isSubmitting = false;
    },
    complete: () => {
      this.isSubmitting = false;
    }
  });
}


}
