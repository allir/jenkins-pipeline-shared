#!/usr/bin/env groovy

/*
 * Send notifications based on build status string
 */

def call(String buildStatus = 'STARTED') {
  // Build status of null means success
  buildStatus = buildStatus ?: 'SUCCESS'

  // Default values
  def color = 'danger'
  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
  def summary = "${subject} (<${env.BUILD_URL}|Open>)"

  // Override default values based on build status
  if (buildStatus == 'STARTED') {
    color = 'warning'
  } else if (buildStatus == 'SUCCESS') {
    color = 'good'
  } else {
    color = 'danger'
  }

  // Send notifications
  slackSend (color: color, message: summary)

}
