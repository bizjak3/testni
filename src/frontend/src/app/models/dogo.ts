import { User } from './user';

export interface Dogo {
  id?: number;
  name?: string;
  breed?: string;
  breedId?: number;
  owner?: User;
}
