resource "aws_instance" "instances" {
  count = 3

  ami = "ami-09d95fab7fff3776c"
  instance_type = "t2.micro"

  subnet_id = "${element(aws_subnet.public_subnet.*.id, count.index)}"

  tags = {
    Name = "jordan_instances"
  }
}