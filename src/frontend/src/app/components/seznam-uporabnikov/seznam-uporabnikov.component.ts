import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import {UserService} from '../../services/user/user.service';
import {SpremeniUporabnikaComponent} from '../spremeni-uporabnika/spremeni-uporabnika.component';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {LoginService} from '../../services/login/login.service';

@Component({
  selector: 'app-seznam-uporabnikov',
  templateUrl: './seznam-uporabnikov.component.html',
  styleUrls: ['./seznam-uporabnikov.component.scss']
})
export class SeznamUporabnikovComponent implements OnInit {
  public user = {
    name: 'Izzat Nadiri',
    age: 26
  };
  public users: User[];

  public loading: boolean = false;
  public error: string | null = null;

  constructor(private userService: UserService, private modalService: NgbModal, private loginServices: LoginService) { }
  public userSedaj = this.loginServices.userLoggedIn;

  ngOnInit(): void {
    this.getData();
  }

  async getData(): Promise<void> {
    this.loading = true;
    this.error = null;
    const observable = await this.userService.getAllUsers();
    console.log('Sem v getData');
    observable.subscribe(
      (data) => {
        console.log('Imam podatke');
        this.users = data;
        this.loading = false;
      },
      () => {
        console.log('Prišlo je do napake');
        this.loading = false;
        this.error = 'Napaka pri pridobivanju podatkov';
      }
    );
  }

  openModal(activityData) {
    const modalRef = this.modalService.open(SpremeniUporabnikaComponent);
    modalRef.componentInstance.uporabnik = activityData;
    console.log(activityData);
    modalRef.result.then((result) => {
      if (result) {
        console.log(result);
      }
    });
    // modalRef.componentInstance.passEntry.subscribe((receivedEntry) => {
    //   console.log(receivedEntry);
    // })
  }

  // public openModal(activityData) {
  //   const modalRef = this.modalService.open(SpremeniUporabnikaComponent);
  //   modalRef.componentInstance.activity = activityData;
  //
  //   modalRef.result
  //     .then(result => {
  //       if (result != null && result != undefined) {
  //         if (result.message === "Deleting was successful") {
  //           this.expenses = this.expenses.filter(item => item._id !== result.item);
  //         } else if (result.message === "Updating was successful") {
  //           const idExpense = result.expense._id;
  //
  //           this.expenses = this.expenses.map(item => {
  //             if (item._id == idExpense) {
  //               return result.expense;
  //             } else return item;
  //           });
  //         }
  //       }
  //     })
  //     .catch(err => {
  //       this.showError(err);
  //       this.openSnackBar("Prišlo je do napake");
  //     });
  // }

}
