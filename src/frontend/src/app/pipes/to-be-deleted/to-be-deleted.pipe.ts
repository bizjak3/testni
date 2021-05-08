import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'toBeDeleted'
})
export class ToBeDeletedPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
