install.packages("factoextra")

library(cluster)
library(factoextra)
 
data <- read.csv(file="input6.csv")
data$Species=NULL

d <- scale(dist(data,method="euclidian"))

kfit <- kmeans(d,3)
#hfit <- hkmeans(d,3)

fviz_cluster(kfit,data)
#fviz_cluster(hfit,data)    