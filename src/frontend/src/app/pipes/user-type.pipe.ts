import { Pipe, PipeTransform } from '@angular/core';
import { User } from '../models/user';

@Pipe({
  name: 'userType',
})
export class UserTypePipe implements PipeTransform {
  transform(user: User): string {
    if (user.isAdmin) return 'Administrator';
    else if (user.isDogOwner) return 'Lastnik psov';
    else return 'Izvajalec storitev';
  }
}
