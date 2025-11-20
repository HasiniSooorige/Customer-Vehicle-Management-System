import { Component } from '@angular/core';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.css']
})
export class VehicleDetailsComponent {


  vehicles: any = [];

  customerId: any;

  ownerName: any;

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
    this.getAllVehicles();
  }

  getAllVehicles() {
    this.customerService.getAllVehicles().subscribe((res) => {
      console.log(res);
      this.vehicles = res;

    })
  }

  getCustomerById(customerId: any) {
    this.customerService.getCustomerById(customerId).subscribe((res) => {
      console.log(res);
      this.ownerName = res.name;
    })
  }
}
