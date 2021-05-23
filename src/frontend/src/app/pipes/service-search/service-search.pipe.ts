import { Pipe, PipeTransform } from '@angular/core';
import { Service } from 'src/app/models/service';

@Pipe({
  name: 'serviceSearch'
})
export class ServiceSearchPipe implements PipeTransform {

  transform(services: Service[], searchTerm: string): Service[] {
    if(services == null || services.length == 0)
      return [];

    return services.filter(e => e.name.toLowerCase().includes(searchTerm.toLowerCase()));
  }

}
