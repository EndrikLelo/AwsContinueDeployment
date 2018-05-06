pipeline {
  agent any

  tools {
    maven 'mvn-3.5.2'
  }

  stages {
    stage('Build') {
      steps {
        sh 'mvn package'
      }
    }
    
    stage('Make Container') {
      steps {
      sh "docker build -t donaldlika/awstest:${env.BUILD_ID} ."
      sh "docker tag donaldlika/awstest:${env.BUILD_ID} donaldlika/awstest:latest"
      }
    }
    
  }

  post {
    always {
      archive 'target/**/*.jar'
      junit 'target/**/*.xml'
    }
    success {
      withCredentials([usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'donaldlika', passwordVariable: 'imthebest4ever')]) {
        sh "docker login -u ${USERNAME} -p ${PASSWORD}"
        sh "docker push donaldlika/awstest:${env.BUILD_ID}"
        sh "docker push donaldlika/awstest:latest"
      }
    }
  }
}