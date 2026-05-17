import { RouterModule, Routes } from "@angular/router";
import { CreateResidentComponent } from "./create-resident-component/create-resident-component";
import { NgModule } from "@angular/core";

const routes : Routes = [
    { 
        path : "create", component :  CreateResidentComponent
    }
]

@NgModule(
    {
        imports : [RouterModule.forChild(routes) ],
        exports : [RouterModule]
    }
)
export class ResidentRoutingModule{};