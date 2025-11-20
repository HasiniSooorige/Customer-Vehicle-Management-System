import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostCustomerComponent } from './components/post-customer/post-customer.component';
import { GetAllCustomersComponent } from './components/get-all-customers/get-all-customers.component';
import { UpdateCustomerComponent } from './components/update-customer/update-customer.component';
import { UserRegisterComponent } from './components/user-register/user-register.component';
import { LoginComponent } from './components/login/login.component';
import { VehicleComponent } from './components/vehicle/vehicle.component';
import { VehicleDetailsComponent } from './components/vehicle-details/vehicle-details.component';

const routes: Routes = [
  { path: 'customer', component: PostCustomerComponent },
  { path: 'dashboard', component: GetAllCustomersComponent },
  { path: 'customer/:id', component: UpdateCustomerComponent },
  { path: 'register', component: UserRegisterComponent },
  { path: '', component: LoginComponent },
  { path: 'vehicle/:id', component: VehicleComponent },
  {path: 'vehicleDetails', component: VehicleDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
