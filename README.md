# Point in Polygon

Solution Type 1:-

Compute the sum of the angles made between the test point and each pair of points
making up the polygon. If this sum is 2pi then the point is an interior point.

https://wrf.ecse.rpi.edu//Research/Short_Notes/pnpoly.html
http://eecs.umich.edu/courses/eecs380/HANDOUTS/PROJ2/InsidePoly.html


Or
 
Solution Type2:- 

Implementation Of Ray casting algorithm

Consider a polygon made up of N vertices (xi,yi) where i ranges from 0 to N-1. The last vertex (xN,yN) is assumed to be the same as the first vertex (x0,y0), that is, the polygon is closed. To determine the status of a point (xp,yp) consider a horizontal ray emanating from (xp,yp) and to the right. If the number of times this ray intersects the line segments making up the polygon is even then the point is outside the polygon. Whereas if the number of intersections is odd then the point (xp,yp) lies inside the polygon.


1. Orientation calculation i.e clockwise, anticlockwise and linear check
2. Projection of vector on X-axix and Y-axis to check intersection

Used resources.
Geometry1z1.pdf attached here with.

or 
http://www.dcs.gla.ac.uk/~pat/52233/slides/Geometry1x1.pdf




Algorithm for plot a polygon with random number of points without crossing edges 

1. find out lowest point.
2. find angle between lowest point and other points respectively
	then create map of point with angle 
3. create a array of points in ascending order based on angle made.
4. plot the polygon based on that array.

