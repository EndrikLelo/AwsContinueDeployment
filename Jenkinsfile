using hostname.

[code language="java"]
node {

    withMaven(maven:'maven') {

        stage('Checkout') {
            git url: 'https://github.com/DonaldLika/AwsContinueDeployment.git', credentialsId: 'github-DonaldLika', branch: 'master'
        }

        stage('Build') {
            sh 'mvn clean install'

            def pom = readMavenPom file:'pom.xml'
            print pom.version
            env.version = pom.version
        }

        stage('Image') {
            dir ('AwsContinueDeployment') {
                def app = docker.build "localhost:5000/AwsCDeploymentTest:${env.version}"
                app.push()
            }
        }      

        stage ('Final') {
            build job: 'AwsCDeploymentTest-pipeline', wait: false
        }      

    }

}