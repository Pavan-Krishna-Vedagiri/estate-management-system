import { Component } from '@angular/core';
import { CommonApiService } from '../../../core/services/common-api-service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Resident } from '../../../shared/models/Resident';
import { RestEndPoints } from '../../../shared/models/endPoints';


@Component({
  selector: 'app-create-resident-component',
  imports: [ReactiveFormsModule],
  templateUrl: './create-resident-component.html',
  styleUrl: './create-resident-component.css',
})
export class CreateResidentComponent {

  residentForm !: FormGroup;

  constructor(private commonApiService: CommonApiService, private fb: FormBuilder) { }

  ngOnInit() {

    this.residentForm = this.fb.group({
      id: [''],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', Validators.required],
      guardianName: [''],
      guardianEmail: ['', Validators.email],
      guardianPhoneNumber: [''],
      socialSecurityNumber: [''],
      occupationName: [''],
      companyName: [''],
      address: this.fb.group({
        addressId: [''],
        doorNo: [''],
        street: [''],
        city: ['', Validators.required],
        country: ['', Validators.required],
        pincode: ['', Validators.required]
      })
    });

  }

  onSubmit() {
    if (this.residentForm.valid) {
      const resident: Resident = this.residentForm.value;
      const resp =  this.commonApiService.get("/residents");
      console.log(resp.subscribe(
        data => console.log(data)
      ))
      alert(
        `Form submited
        ${this.residentForm.value}
        `
      )
      console.log(this.residentForm.value)
    }
    else {
      alert("Invalid form")
    }
  }
}
