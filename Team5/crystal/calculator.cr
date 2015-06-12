class Calculate
  def initialize(file)
    @dept = 1
    @sum = 0
    puts calculate(file)
  end

  def calculate(file)
    File.open(file, "r") do |infile|
      while (line = infile.gets)
        line.each_char do |sym|
          @dept += 1 if(sym == '{')
          @dept -= 1 if(sym == '}')
          @sum = @sum + @dept * 1 if (sym == ';')
        end
      end
      @sum
    end
  end
end

ARGV.each do |f|
  Calculate.new(f)
end
