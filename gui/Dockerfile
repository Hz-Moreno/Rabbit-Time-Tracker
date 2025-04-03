# Use Node.js image to build the frontend
FROM node:18 as build-stage

WORKDIR /app

# Copy package.json and install dependencies
COPY package.json package-lock.json ./
RUN npm install

# Copy the rest of the application and build
COPY . .
RUN npm run build

# Serve the built files using Nginx
FROM nginx:alpine
COPY --from=build-stage /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]

