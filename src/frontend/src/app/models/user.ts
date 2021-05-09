import { Dogo } from './dogo';

export interface User {
  id?: number;
  name?: string;
  surname?: string;
  email?: string;
  username?: string;
  password?: string;
  isDogOwner?: boolean;
  isServiceWorker?: boolean;
  isAdmin?: boolean;
  dogos?: Dogo[];
}
