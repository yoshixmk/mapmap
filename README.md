# ts-boilerplate

this repository is for typescript beginners.  
you can start typescript soon with this repository. :))

## Requirement

this repository is assumed to work in such environment as below.

 ```
> node -v
v13.13.0

> npm -v 
6.14.4

> yarn -v
1.22.4
```

## Do first after pulling this repository

you should do this command.  
this command means you are going to install the packages into your working directory.

```
yarn install
```

## Run

there are some reserved `npm-scripts`.  
here are they.  
`npm-scripts` is in the `script` section in `package.json`

```
yarn start
```
start js program. the entrypoint is `dist/index.js`  
you have to `translate` `ts` files into `js` files at first.  
(this `translation` is called `transpile` .)

```
yarn compile
```
transpile `src/*.ts` files into `dist/*.js` files.
 
```
yarn dev
```
start `ts` program without transpiling. the entrypoint is `src/index.ts` .

```
yarn watch
``` 
start `ts` program without transpiling. once the `src/*.ts` codes are changed, the running program will immediately automatically restart.

```
yarn clean
```
remove `dist/*.js` files.

```
yarn build
```
automatically remove `dist/*.js` and transpile `src/*.ts` .