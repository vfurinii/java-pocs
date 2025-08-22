FROM postgres:latest

COPY schema.sql /docker-entrypoint-initdb.d/schema.sql

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=password
ENV POSTGRES_DB=postgres