  data <- read.csv(file="input5.csv")
  
  age <- data[1:7,1:1]
  circum <- data[1:7,2:2]
  plot(age,circum,xlab="age",ylab="circum")
  
  data <- data.frame(age,circum)
  model <- lm(circum ~ age,data)
  summary(model)
  
  abline(model,cex=1)
  
  newData <- data.frame(age=700)
  result <- predict(model,newData)
  print(result)