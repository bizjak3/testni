import { Location } from './location';
import { ServiceDiary } from './service_diary';
import { User } from './user';

export interface Service {
  id?: number;
  name?: string;
  description?: string;
  restrictions?: string;
  dateFrom?: Date;
  dateTo?: Date;
  author?: User;
  locations?: Location[];
  serviceDiaries?: ServiceDiary[];
}
