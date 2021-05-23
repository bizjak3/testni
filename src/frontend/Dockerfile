# stage 1

FROM node:alpine AS my-app-build
WORKDIR /app
COPY . .
RUN npm install -g @angular/cli
RUN npm install

ARG mode
RUN if [ "x$mode" = "xdev" ] ; then echo ng build ; else echo ng build --prod; fi

# stage 2

FROM nginx:alpine
RUN apk add bash
COPY --from=my-app-build /app/dist/frontend /usr/share/nginx/html
COPY --from=my-app-build /app/nginx.conf /etc/nginx/conf.d/
RUN rm /etc/nginx/conf.d/default.conf
EXPOSE 80
