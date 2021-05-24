export interface MessageRoot {
  username: string;
  messages: MessageSimple[];
}

export interface MessageSimple {
  text: string;
  created: string;
  sendByMe: string;
}