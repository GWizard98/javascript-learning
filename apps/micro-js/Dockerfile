FROM node:20-alpine
WORKDIR /usr/src/app
COPY package.json package-lock.json* ./
RUN npm ci --omit=dev || npm install --omit=dev
COPY src ./src
# public is mounted via volume in compose for live editing
ENV PORT=3000
EXPOSE 3000
CMD ["npm", "start"]
