node {
    stage('get code') {
        git branch: 'main', credentialsId: 'gitlab_credentials', url: 'https://gitlab.com/f464/nopcommerce_automation_framework'      
    }
    stage('compile and build') {
        bat 'mvn clean test'
    }
    stage('print build status') {
        echo 'Build Complete'
    }
}