pipeline {
    agent { node { label 'fargate-mip-be' } }
    stages{
        stage('CheckOut'){
            checkout scm
        }
    }
}