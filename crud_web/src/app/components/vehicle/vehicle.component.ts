import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent {

  addVehicleForm!: FormGroup;
  customerId: number = this.activatedRoute.snapshot.params["id"];

  constructor(private activatedRoute: ActivatedRoute,
    private service: CustomerService,
    private fb: FormBuilder,
    private router: Router) { }

  ngOnInit() {
    this.addVehicleForm = this.fb.group({
      name: [null, [Validators.required]],
      description: [null, [Validators.required]],
      color: [null, [Validators.required]],
      type: [null, [Validators.required]],
      mileage: [null, [Validators.required]],
      customerId:this.customerId
    })
  }

  addVehicle() {
    this.service.addVehicle(this.addVehicleForm.value).subscribe((res) => {
      console.log(res);
      if (res.id != null) {
        this.router.navigateByUrl("/dashboard")
      }
    })
  }

}
